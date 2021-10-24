final class Acting {
    private String value;

    public Acting(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Acting other) {
        return (this == other) || other instanceof Acting && equalTo((Acting) other);
    }

    public boolean equalsTo(Acting other) {
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
