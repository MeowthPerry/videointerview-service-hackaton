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
// let vacancy = fetch('http://127.0.0.1:8080/api/admin/vacancy' , {
let vacancy = fetch(
    'http://127.0.0.1:8080/api/admin/vacancy', {
      method: 'get'
    })
.then(status)
.then(json)
.catch(function (error) {
  console.log('error', error)
})

vacancy.then(function (result) {
  result.forEach((vacancy) => {
    const option = document.createElement('option');
    option.value = vacancy.id;
    option.textContent = vacancy.name;
    selectList.forEach((list) => {
      const opt = option.cloneNode(true);
      list.appendChild(opt)
    });
    const vacTable = document.querySelector('.table2');
    const innerTable = vacTable.querySelector('tbody');
    const row = document.createElement('tr');
    const vacancyName = document.createElement('td');
    const vacancyInfo = document.createElement('td');
    let questionsRow = '<td>';
    vacancy.questions.forEach((question) => {
      questionsRow += question.content + ' <br> ';
    });
    vacancyName.textContent = vacancy.name;
    vacancyInfo.textContent = questionsRow;
    row.appendChild(vacancyName);
    row.innerHTML += questionsRow + '</td>';
    innerTable.appendChild(row);

  });
});
//ADD USER
const addUserButton = document.querySelector('.add-user-button');
addUserButton.addEventListener('click', (evt) => {
  evt.preventDefault();
  const userName = document.querySelector('input[name=userName]').value;
  const vacancyId = document.querySelector('.selector1').value;
  fetch('http://127.0.0.1:8080/api/admin/user', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      username: userName,
      vid: vacancyId
    })
  })
})

//ADD VACANCY
const addVacancyButton = document.querySelector('.add-vacancy-button');
addVacancyButton.addEventListener('click', (evt) => {
  evt.preventDefault();
  const vacancyName = document.querySelector('input[name=vacancyName]').value;
  const vacJson = JSON.stringify(vacancyName);
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
  const vacancyId = document.querySelector('.selector2').value;
  fetch('http://127.0.0.1:8080/api/admin/vacancy/' + vacancyId + '/question', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      content: questionText
    })
  })
})

////TABLE ULTRA

let videoTable = fetch(
    'http://127.0.0.1:8080/api/admin/user', {
      method: 'get'
    })
.then(status)
.then(json)
.catch(function (error) {
  console.log('error', error)
})

videoTable.then(function (result) {
  const tableBody = document.querySelector('.table1 tbody');
  const tableR = document.createElement('tr');
  console.log(result)
  result.forEach((row) => {
    const userId = row.id;
    const userName = row.username;
    const url = row.url;
    const vacancy = row.vacancy;

    const tableRow = tableR.cloneNode(false);
    const userIdTd = document.createElement('td');
    userIdTd.textContent = userId;
    const userNameTd = document.createElement('td');
    userNameTd.textContent = userName;
    const vacancyTd = document.createElement('td');
    vacancyTd.textContent = vacancy;
    const urlTd = document.createElement('td');
    if (url === null) {
      urlTd.textContent = 'null';
    } else {
      const videoLink = document.createElement('a');
      videoLink.href = url;
      videoLink.textContent = 'Показать собеседование';
      urlTd.appendChild(videoLink);
    }

    tableRow.appendChild(userIdTd);
    tableRow.appendChild(userNameTd);
    tableRow.appendChild(vacancyTd);
    tableRow.appendChild(urlTd);
    tableBody.appendChild(tableRow);
  })
});