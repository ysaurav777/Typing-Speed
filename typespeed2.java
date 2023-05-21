let speedTypingTestEl = document.getElementById("speedTypingTest");
let timerEl = document.getElementById("timer");
let resultEl = document.getElementById("result");
let quoteDisplayEl = document.getElementById("quoteDisplay");
let quoteInputEl = document.getElementById("quoteInput");
let submitBtnEl = document.getElementById("submitBtn");
let resetBtnEl = document.getElementById("resetBtn");
let spinnerEl = document.getElementById("spinner");
let uniqueNo = null;

function timerInterval() {
    let counter = 1;
    uniqueNo = setInterval(function() {
        timerEl.textContent = counter + " seconds";
        timerEl.classList.add("secs");
        counter = counter + 1;
    }, 1000);
}

function startUp() {
    let options = {
        method: "GET"
    };
    spinnerEl.classList.remove("d-none");
    fetch("https://apis.ccbp.in/random-quote", options)
        .then(function(response) {
            return response.json();
        })
        .then(function(jsonText) {
            spinnerEl.classList.add("d-none");
            quoteDisplayEl.textContent = jsonText.content;
            quoteDisplayEl.classList.add("secs1");
        });
}

timerInterval();
startUp();

function submit1() {
    if (quoteDisplayEl.textContent === quoteInputEl.value) {
        clearInterval(uniqueNo);
        resultEl.textContent = "You typed in " + timerEl.textContent;
    } else {
        resultEl.textContent = "You typed incorrect sentence";
    }
}

function result1() {
    timerInterval();
    startUp();
}

submitBtnEl.addEventListener("click", submit1);
resetBtnEl.addEventListener("click", result1);