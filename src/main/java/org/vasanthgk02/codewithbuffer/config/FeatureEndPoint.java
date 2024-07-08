package org.vasanthgk02.codewithbuffer.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndPoint {

    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndPoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(true));
        featureMap.put("Authentication", new Feature(true));
    }

    @ReadOperation
    public Map<String, Feature> features() {
        return featureMap;
    }

    @ReadOperation
    public Feature getFeature(@Selector String name) {
        return featureMap.get(name);
    }

    @Data
    @AllArgsConstructor
    public static class Feature {
        private final Boolean isEnabled;

    }

}
