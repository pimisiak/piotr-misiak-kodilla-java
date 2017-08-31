package com.kodilla.good.patterns.challenges.order;

public class InformationImpl implements Information {
    private final String information;
    private final User user;

    private InformationImpl(final Builder builder) {
        this.information = builder.information;
        this.user = builder.user;
    }

    @Override
    public String getInformation() {
        return information;
    }

    @Override
    public User getUser() {
        return user;
    }

    static class Builder {
        private String information;
        private User user;

        Builder information(final String information) {
            this.information = information;
            return this;
        }

        Builder user(final User user) {
            this.user = user;
            return this;
        }

        InformationImpl build() {
            return new InformationImpl(this);
        }
    }
}
