class Note {
    constructor(content, status) {
        this.content = content;
        this.status = status;
    }
}

noteList = null;

function loadNotes() {
    noteList = JSON.parse(localStorage.getItem("noteList"));
    if (noteList == null) {
        noteList = []
        return;
    }
    for (const note of noteList) {
        addNote(note.content, note.status);
    }
}

function addShortcutNewNoteButton() {
    const button = document.getElementById('note-input');
    button.addEventListener("keyup", e => {
        e.preventDefault();
        if (e.keyCode === 13) {
            document.getElementById('add-todo').click();
        }
    });
    button.focus();
}

function isValidNote(content) {
    if (content.trim() === '') return false;
    for (const note of noteList) {
        if (content === note.content)
            return false;
    }
    return true;
}

function changeNoteStatusInList(content, newStatus) {
    for (const note of noteList) {
        if (note.content === content) {
            note.status = newStatus;
            break;
        }
    }
}

function changeNoteStatus(event) {
    const srcElement = event.srcElement;
    const isDoneNote = srcElement.className === 'done note-content';

    if (isDoneNote) {
        srcElement.className = 'to-do note-content';
        changeNoteStatusInList(srcElement.textContent, 'to-do');
    }
    else {
        srcElement.className = 'done note-content';
        changeNoteStatusInList(srcElement.textContent, 'done');
    }
    localStorage.setItem("noteList", JSON.stringify(noteList));
}

function addNote(content, status) {
    const table = document.getElementById('note-table');
    const row = document.createElement('tr');
    const cell = document.createElement('td');
    cell.textContent = content;
    cell.className = status + ' note-content';
    cell.addEventListener('click', event => changeNoteStatus(event));
    row.appendChild(cell);
    table.appendChild(row);
}

function addNewNote() {
    const input = document.getElementById('note-input');
    if (isValidNote(input.value.trim())) {
        addNote(input.value, 'to-do');
        noteList.push(new Note(input.value, 'to-do'));
        input.value = '';
        input.focus();
    }
    localStorage.setItem("noteList", JSON.stringify(noteList));
}

function removeDoneNotes() {
    const notes = document.getElementsByClassName('note-content');
    const table = document.getElementById('note-table');
    let index = 0, length = notes.length;

    while (index < length) {
        if (notes[index].className === 'done note-content') {
            noteList.splice(index, 1);
            table.removeChild(notes[index].parentNode);
            length--;
        }
        else index++;
    }
    localStorage.setItem("noteList", JSON.stringify(noteList));
}

function removeAllNotes() {
    const table = document.getElementById('note-table');
    table.innerHTML = '';
    noteList = [];
    localStorage.setItem("noteList", JSON.stringify(noteList));
}