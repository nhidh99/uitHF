let username;

function sayHello() {
    if (navigator.cookieEnabled) {
        username = readCookie("irock_username");
    }
    if (username) {
        alert('It is nice to meet you again, ' + username);
        beHappyRock();
    }
    else alert('Hello, I am your pet rock!');
}

function askForName() {
    if (username) {
        alert('I like the attention, ' + username + '. Thank you!');
        beHappyRock();
    }
    else {
        username = prompt('My name is iRock. What is your name?');
        if (username) {
            alert('It is nice to meet you, ' + username + '!');
            if (navigator.cookieEnabled) {
                writeCookie("irock_username", username, 5 * 365);
            }
            else {
                alert('The cookie in this browser is not available. I will forget you later. Sorry');
            }
            beHappyRock();
        }
    }
}

function beHappyRock() {
    const rock = document.getElementById('rock');
    rock.src = 'img/rock_happy.png';
    setTimeout(() => {
        rock.src = 'img/rock.png';
    }, 5000);
}

function resizeRock() {
    const rock = document.getElementById('rock');
    rock.style.height = (window.innerHeight - 100) * 0.5 + "px";
}