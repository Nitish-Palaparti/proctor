package com.indeed.proctor.common.model;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Allocation {
    @Nullable
    private String rule;

    /**
     * Map from a bucket name
     */
    @Nonnull
    private List<Range> ranges = Collections.emptyList();

    @Nonnull
    private String id = "";

    public Allocation() { /* intentionally empty */ }

    public Allocation(@Nullable final String rule,
                      @Nonnull final List<Range> ranges) {
        this(rule, ranges, "");
    }

    public Allocation(@Nullable final String rule,
                      @Nonnull final List<Range> ranges,
                      @Nullable final String id) {
        this.rule = rule;
        this.ranges = ranges;
        this.id = Strings.nullToEmpty(id);
    }

    public Allocation(@Nonnull final Allocation other) {
        this.rule = other.rule;
        this.ranges = new ArrayList<>();
        for (final Range range : other.getRanges()) {
            this.ranges.add(new Range(range));
        }
        this.id = other.id;
    }

    @Nullable
    public String getRule() {
        return rule;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setRule(@Nullable final String rule) {
        this.rule = rule;
    }

    @Nonnull
    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(@Nonnull final List<Range> ranges) {
        this.ranges = ranges;
    }

    @Nonnull
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = Strings.nullToEmpty(id);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Allocation that = (Allocation) o;
        return Objects.equal(rule, that.rule) &&
                Objects.equal(ranges, that.ranges) &&
                Objects.equal(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rule, ranges, id);
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "rule='" + rule + '\'' +
                ", ranges=" + ranges +
                ", id='" + id + '\'' +
                '}';
    }
}
