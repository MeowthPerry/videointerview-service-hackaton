import {responseData} from './data.js';

let array = responseData.then( function (result) {
    document.querySelector('.header__user-name').textContent = result.name;
    document.querySelector('.vacancy-name_span').textContent = result.vacancy;
    const questions = result.questions;

    const questionsInserter = (questions) => {
        for (let i = 0; i < questions.length; i++) {
            const tag = questionCreator(questions[i]);
            questionList.appendChild(tag);
        }
    };
    questionsInserter(questions);
    bolderText(questionList);
});

const questionList = document.querySelector('.interview-content-questions');
const nextButton = document.querySelector('#next');
const startButton = document.querySelector('#start');
const stopButton = document.querySelector('#stop');

const questionCreator = (item) => {
    const tag = document.createElement('p');
    tag.classList.add('questions-text');
    tag.textContent = item;
    return tag;
};

const bolderText = (parent) => {
    const items = parent.querySelectorAll('p')
    items[0].classList.add('active');
};

startButton.addEventListener('click', () => {
    startButton.classList.add('hidden');
    nextButton.classList.remove('hidden');
    const message = new SpeechSynthesisUtterance();
    message.lang = "ru-RU";
    message.text = questionList.children[0].textContent;
    window.speechSynthesis.speak(message);
});

nextButton.addEventListener('click', () => {
    if(questionList.children.length === 2) {
        questionList.children[0].remove();
        bolderText(questionList);
        nextButton.classList.add('hidden');
        stopButton.classList.remove('hidden');
        const message = new SpeechSynthesisUtterance();
        message.lang = "ru-RU";
        message.text = questionList.children[0].textContent;
        window.speechSynthesis.speak(message);
    } else {
        questionList.children[0].remove();
        bolderText(questionList);
        const message = new SpeechSynthesisUtterance();
        message.lang = "ru-RU";
        message.text = questionList.children[0].textContent;
        window.speechSynthesis.speak(message);
    }
});

stopButton.addEventListener('click', () => {
    const text = `Спасибо за интервью!
    Мы с Вами свяжемся!`;
    questionList.children[0].textContent = text;
    bolderText(questionList);
    const message = new SpeechSynthesisUtterance();
    message.lang = "ru-RU";
    message.text = text;
    window.speechSynthesis.speak(message);
    stopButton.classList.add('hidden');
});