package com.vinicius.goncalves.enums;

public enum ToggleSlots {

    OWNER(Tags.OWNER, 19),
    ADMIN(Tags.ADMIN, 20),
    MEMBER(Tags.MEMBER, 21);

    final Tags tag;
    final int slot;

    ToggleSlots(Tags tag, int slot) {
        this.tag = tag;
        this.slot = slot;
    }

    public int getSlot() {
        return this.slot;
    }

    public Tags getTag() {
        return this.tag;
    }
}
