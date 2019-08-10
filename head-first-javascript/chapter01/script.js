function sayHello() {
    alert('Hello, I am your rock!');
}

function askForName() {
    const name = prompt('My name is iRock. What is your name?');
    if (name) {
        alert('It is nice to meet you, ' + name + '!');
        const rock = document.getElementById('rock');
        rock.src = 'img/rock_happy.png';
    }
}