var status = function (response) {
    if (response.status !== 200) {
        return Promise.reject(new Error(response.statusText));
    }
    return Promise.resolve(response);
}
var json = function (response) {
    return response.json();
}

var promise = fetch('http://127.0.0.1:8080/api/candidate/1', {
    method: 'get'
})
.then(status)
.then(json)
.catch(function (error) {
    console.log('error', error)
})

// const responseData = promise.then((data) => {return data});

const responseData = {
    name: 'Имя Из Ответа',
    vacancy: 'Senior HTML language programmer',
    questions: [
        'Сколько вам лет?',
        'Как вас зовут?',
        'какую вы хотите зарплату?',
        'Расскажите про ваш опыт работы',
        'Что вы думаете о компьютерах?',
        'Вам нравится зеленый цвет?',
        'Сколько лет вы занимаетесь разработкой? (включая обучение)',
        'Какие проекты вы реализовали?',
        'Чай или кофе?'
    ]
};

export { responseData };
