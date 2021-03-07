package com.matthem.driverlandscape;

import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;
import java.util.Objects;

@RelationshipProperties
public class DriverSupportedTransport {

    private final List<String> versions;

    @TargetNode
    private final DriverTransport transport;

    public DriverSupportedTransport(List<String> versions, DriverTransport transport) {
        this.versions = versions;
        this.transport = transport;
    }

    public List<String> getVersions() {
        return versions;
    }

    public DriverTransport getTransport() {
        return transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverSupportedTransport that = (DriverSupportedTransport) o;
        return Objects.equals(versions, that.versions) && Objects.equals(transport, that.transport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(versions, transport);
    }

    @Override
    public String toString() {
        return "DriverSupportedTransport{" +
                "versions=" + versions +
                ", transport=" + transport +
                '}';
    }
}
