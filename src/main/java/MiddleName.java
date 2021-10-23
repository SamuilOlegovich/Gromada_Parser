final class MiddleName {
    private String value;

    public MiddleName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return (this == other) || other instanceof MiddleName && equalTo((MiddleName) other);
    }

    public boolean equalsTo(MiddleName other) {
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return 44;
    }
}
