// Initialize the current scene to Scene 0 (Intro)
let curScene = 0;
let sceneCount = 1;

function updateScene(message, decision1, decision2) {
    // Update the scene image
    document.getElementById("sceneimg").src = "scene" + curScene + ".png";

    // Update the scene description text
    document.getElementById("scenetext").innerHTML = message;

    // Update the decision
    const button1 = document.getElementById("decision1");
    const button2 = document.getElementById("decision2");
    button1.innerHTML = decision1;

    if (decision2 == "") {
        button2.style.visibility = "hidden";
    } else {
        button2.innerHTML = decision2;
        button2.style.visibility = "visible";
    }
}

function updateHistory(message, decisionNumber) {
    const history = document.createElement('p');
    history.innerHTML = `Scene ${sceneCount++}: ${message}`;
    document.getElementById('history').appendChild(history);
}

function clearHistory() {
    document.getElementById('history').innerHTML = '';
    sceneCount = 1;
}

function changeScene(decision) {
    // Clear the scene message
    let message = "";
    let decision1 = "";
    let decision2 = "";

    switch (curScene) {
        case 0:
            curScene = 1;
            message = "Your journey begins at a fork in the road.";
            decision1 = "Take the path";
            decision2 = "Take the bridge";
            break;

        case 1:
            if (decision == 1) {
                curScene = 2;
                message = "You have arrived at a cute little house in the woods.";
                decision1 = "Walk around back";
                decision2 = "Knock on door";
            } else {
                curScene = 3;
                message =
                    "You are standing on the bridge overlooking a peaceful stream.";
                decision1 = "Walk across birdge";
                decision2 = "Gaze into stream";
            }
            break;

        case 2:
            if (decision == 1) {
                curScene = 4;
                message =
                    "Peeking through the window, you see a witch inside the house.";
                decision1 = "Sneak by window";
                decision2 = "Wave at witch";
            } else {
                curScene = 5;
                message =
                    "Sorry, a witch lives in the house and you just became part of her stew.";
                decision1 = "Restart Game";
            }
            break;

        case 3:
            if (decision == 1) {
                curScene = 6;
                message =
                    "Sorry, a troll lives on the other side of the bridge and you just became his lunch.";
                decision1 = "Restart Game";
            } else {
                curScene = 7;
                message =
                    "Your stare is interrupted by the arrival of a huge troll.";
                decision1 = "Say hello to troll";
                decision2 = "Jump into stream";
            }
            break;

        case 4:
            if (decision == 1) {
                curScene = 8;
                message = "To be continue...";
                decision1 = "Restart Game";
            } else {
                curScene = 5;
                message = "Sorry, you became part of the witch's stew.";
                decision1 = "Restart Game";
            }
            break;

        case 5:
            curScene = 0;
            decision1 = "Start Game";
            break;

        case 6:
            curScene = 0;
            decision1 = "Start Game";
            break;

        case 7:
            if (decision == 1) {
                curScene = 6;
                message = "Sorry, you became the troll's tasty lunch.";
                decision1 = "Restart Game";
            } else {
                curScene = 9;
                message = "To be continue...";
                decision1 = "Restart Game";
            }
            break;

        case 8:
            curScene = 0;
            decision1 = "Restart Game";
            break;

        case 9:
            curScene = 0;
            decision1 = "Restart Game";
            break;
    }

    updateScene(message, decision1, decision2);

    if (curScene == 0) {
        clearHistory();
    }
    else updateHistory(message, decision);
}