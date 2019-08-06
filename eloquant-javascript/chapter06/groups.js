class Group {
    constructor() {
        this.elements = [];
    }

    add(value) {
        if (!this.elements.includes(value)) {
            this.elements.push(value);
        }
    }

    del(value) {
        let index = this.elements.indexOf(value);
        if (index > -1) {
            this.elements.splice(index, 1);
        }
    }

    static from(obj) {
        let group = new Group();
        for (let value of obj) {
            group.add(value);
        }
        return group;
    }
}

let group = new Group();
group.add(1);
group.add(2);
group.add(3);
console.log(group.elements);

group.del(1);
group.del(4);
group.del(5);
console.log(group.elements);

let arr = [1,1,2,2,2,3];
console.log(Group.from(arr));