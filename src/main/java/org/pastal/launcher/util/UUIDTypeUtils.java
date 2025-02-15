package org.pastal.launcher.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.UUID;

public final class UUIDTypeUtils extends TypeAdapter<UUID> {
    public UUIDTypeUtils() {
    }

    public static String fromUUID(UUID value) {
        return value.toString().replace("-", "");
    }

    public static UUID fromString(String input) {
        return UUID.fromString(input.replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
    }

    public void write(JsonWriter out, UUID value) throws IOException {
        out.value(fromUUID(value));
    }

    public UUID read(JsonReader in) throws IOException {
        return fromString(in.nextString());
    }
}
