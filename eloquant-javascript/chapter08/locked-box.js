const box = {
    locked: true,
    unlock() { this.locked = false; },
    lock() { this.locked = true; },
    _content: [],

    get content() {
        if (this.locked) throw new Error("Locked!");
        return this._content;
    },

    withBoxUnlocked(func) {
        const isLocked = this.locked;
        this.unlock();
        func();
        if (isLocked) {
            this.lock();
        }
    }
};

box.withBoxUnlocked(() => console.log('Func'));
console.log(box.locked);

box.unlock();
box.withBoxUnlocked(() => console.log('Func'));
console.log(box.locked);