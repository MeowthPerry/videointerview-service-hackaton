const questions = [
    'Сколько вам лет?',
    'Как вас зовут?',
    'какую вы хотите зарплату?',
    'Расскажите про ваш опыт работы',
    'Что вы думаете о компьютерах?',
    'Вам нравится зеленый цвет?',
    'Сколько лет вы занимаетесь разработкой? (включая обучение)',
    'Какие проекты вы реализовали?',
    'Чай или кофе?'
];

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

const questionsInserter = (questions) => {
    for (let i = 0; i < questions.length; i++) {
        const tag = questionCreator(questions[i]);
        questionList.appendChild(tag);
    }
};

const bolderText = (parent) => {
    const items = parent.querySelectorAll('p')
    items[0].classList.add('active');
};


startButton.addEventListener('click', () => {
    startButton.classList.add('hidden');
    nextButton.classList.remove('hidden');
});

nextButton.addEventListener('click', () => {
    if(questionList.children.length === 2) {
        questionList.children[0].remove();
        bolderText(questionList);
        nextButton.classList.add('hidden');
        stopButton.classList.remove('hidden');
    } else {
        questionList.children[0].remove();
        bolderText(questionList);
    }
});

stopButton.addEventListener('click', () => {
    questionList.children[0].textContent = `Спасибо за интервью!
    Мы с Вами свяжемся!`;
    bolderText(questionList);
    stopButton.classList.add('hidden');
});

questionsInserter(questions);

bolderText(questionList);

