package medidasBackend.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SexEnum {
    MALE("Masculino"),
    FEMALE("Femenino"),
    OTHER("Otro");

    private final String value;

    SexEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue(){return this.value;}

    @Override
    public String toString() {return String.valueOf(this.value);}

    @JsonCreator
    public static SexEnum fromValue(String text) {
        for (SexEnum val : SexEnum.values()) {
            if (val.value.equals(text))  return val;

        }
        throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
}
