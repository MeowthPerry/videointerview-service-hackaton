const selectList = document.querySelectorAll('.selector');

const status = function (response) {
  if (response.status !== 200) {
    return Promise.reject(new Error(response.statusText));
  }
  return Promise.resolve(response);
}
const json = function (response) {
  return response.json();
}
let vacancy = fetch('http://127.0.0.1:8080/api/admin/vacancy' , {
// let vacancy = fetch('https://run.mocky.io/v3/93215ae8-0ab1-477f-a91c-5011a5bca0f7' , {
  method: 'get',
  headers: {
    'Key': 'secret'
  },
})
.then(status)
.then(json)
.catch(function (error) {
  console.log('error', error)
})

vacancy.then( function (result) {
  result.forEach((vacancy) => {
    const option = document.createElement('option');
    option.value = vacancy.id;
    option.textContent = vacancy.name;
    selectList[0].appendChild(option);
    selectList[1].appendChild(option);
    selectList.forEach((list) => {
      const opt =  option.cloneNode(true)
      list.appendChild(opt);
    })
  });
});
//ADD USER
const addUserButton = document.querySelector('.add-user-button');
addUserButton.addEventListener('click', (evt) => {
  evt.preventDefault();
  const userName = document.querySelector('input[name=userName]').value;
  const vacancyId = document.querySelector('.selector').value;
  fetch('http://localhost:8080/api/admin/user', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({username: userName, vid: vacancyId})
  })
})

//ADD VACANCY
const addVacancyButton = document.querySelector('.add-vacancy-button');
addVacancyButton.addEventListener('click', (evt) => {
  evt.preventDefault();
  const vacancyName = document.querySelector('input[name=vacancyName]').value;
  console.log(vacancyName)
  fetch('http://127.0.0.1:8080/api/admin/vacancy', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({name: vacancyName})
  })
})

//ADD QUESTIONS
const addQuestionButton = document.querySelector('.add-question-button');
addQuestionButton.addEventListener('click', (evt) => {
  evt.preventDefault();
  const questionText = document.querySelector('input[name=questionText]').value;
  const vacancyId = document.querySelector('.selector').value;
  fetch('http://127.0.0.1:8080/api/admin/vacancy/' + vacancyId + '/question', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({content: questionText})
  })
})