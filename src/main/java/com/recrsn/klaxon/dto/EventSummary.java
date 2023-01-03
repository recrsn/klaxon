package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Event;
import com.recrsn.klaxon.models.Tag;
import dev.hilla.Nonnull;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public final class EventSummary {
    @Nonnull
    private final UUID id;
    @Nonnull
    private final Map<String, @Nonnull String> tags;
    @Nonnull
    private final String key;
    @Nonnull
    private final Map<String, @Nonnull String> data;

    public EventSummary(UUID id, String key, Map<String, String> data, Map<String, String> tags) {
        this.id = id;
        this.key = key;
        this.data = data;
        this.tags = tags;
    }

    public static EventSummary from(Event event) {
        var definition = event.getDefinition();
        var tags = event.getTags()
                .stream()
                .collect(Collectors.toMap(t -> t.getDefinition().getKey(), Tag::getValue));
        return new EventSummary(event.getId(), definition.getKey(), event.getData(), tags);
    }

    public String key() {
        return key;
    }

    public Map<String, String> data() {
        return data;
    }

    public Map<String, String> tags() {
        return tags;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (EventSummary) obj;
        return Objects.equals(this.key, that.key) &&
                Objects.equals(this.data, that.data) &&
                Objects.equals(this.tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, data, tags);
    }

    @Override
    public String toString() {
        return "EventSummary[" +
                "key=" + key + ", " +
                "data=" + data + ", " +
                "tags=" + tags + ']';
    }

}
