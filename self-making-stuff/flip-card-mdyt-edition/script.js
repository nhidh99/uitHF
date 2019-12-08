let flip_count = 0;
let prev_card = null;
let isChecking = false;
let flip_audio = null;

function playFlipSound() {
    flip_audio.pause();
    flip_audio.currentTime = 0;
    flip_audio.play();
}

function loadCards() {
    flip_audio = document.getElementById('flip-audio');
    const rows = document.getElementsByClassName("play-row");
    const nums = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6];
    
    for (const row of rows) {
        for (let i = 0; i < 4; i++) {
            const index = Math.floor(Math.random() * nums.length);
            const num = nums[index];
            nums.splice(index, 1);

            row.innerHTML +=
                `<td>
                <div class='flip-card' >
                <div class='flip-card-inner' name="card-${num}" onclick="openCard(this)">
                    <div id='front-card' class='flip-card-front'>
                        <img class='card' src='images/front-card.png'/>
                    </div>
                    <div id='back-card' class='flip-card-back'>
                        <img class='card' src='images/back-card-${num}.png'>
                    </div>
                </div>
                </div >
            </td > `;
        }
    }
}

const sleep = (ms) => new Promise(resolve => setTimeout(resolve, ms));

const openCard = async (card) => {
    if (isChecking) return;

    playFlipSound();
    card.style.transform = "rotateY(180deg)";
    card.onclick = () => closeCard(card);

    switch (flip_count++) {
        case 0: {
            prev_card = card;
            break;
        }
        case 1: {
            // Disable click card (delay a while to show card and check)
            isChecking = true;
            prev_card.onclick = null;
            card.onclick = null;

            // Delay and check card
            await sleep(1000);
            const prev_name = prev_card.getAttribute("name");
            const cur_name = card.getAttribute("name");

            if (prev_name === cur_name) {
                flip_count = 0;
            }
            else {
                closeCard(card);
                closeCard(prev_card);
            }

            isChecking = false;
            break;            
        }
    }
}

const closeCard = (card) => {
    playFlipSound();
    card.style.transform = "";
    card.onclick = () => openCard(card);
    flip_count--;
}