package com.matthem.driverlandscape;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Node(primaryLabel = "Driver")
public class Neo4jDriver {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID id;
    private final String uri;
    private final boolean official;

    @Relationship(type = "SUPPORTS", direction = OUTGOING)
    private final List<DriverSupportedTransport> supportedTransports;

    public Neo4jDriver(String uri, boolean official, List<DriverSupportedTransport> supportedTransports) {
        this.uri = uri;
        this.official = official;
        this.supportedTransports = supportedTransports;
    }

    public Neo4jDriver wihId(UUID uuid) {
        if (uuid.equals(id)) {
           return this;
        }

        Neo4jDriver driver = new Neo4jDriver(this.uri, this.official, this.supportedTransports);
        driver.id = uuid;
        return driver;
    }

    public String getUri() {
        return uri;
    }

    public boolean isOfficial() {
        return official;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neo4jDriver that = (Neo4jDriver) o;
        return official == that.official && Objects.equals(uri, that.uri) && Objects.equals(supportedTransports, that.supportedTransports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, official, supportedTransports);
    }

    @Override
    public String toString() {
        return "Neo4jDriver{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", official=" + official +
                ", supportedTransports=" + supportedTransports +
                '}';
    }
}
