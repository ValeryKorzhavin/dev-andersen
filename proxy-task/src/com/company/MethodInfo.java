package com.company;

import java.util.Arrays;

public final class MethodInfo {

    private final String methodName;

    private final Object[] args;

    public MethodInfo(String methodName, Object[] args) {
        this.methodName = methodName;
        this.args = Arrays.copyOf(args, args.length);
    }

    @Override
    public int hashCode() {
        return methodName.hashCode() + Arrays.hashCode(args);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MethodInfo)) {
            return false;
        }

        MethodInfo that = (MethodInfo) obj;
        return Arrays.equals(this.args, that.args)
                && this.methodName.equals(that.methodName);
    }

}
