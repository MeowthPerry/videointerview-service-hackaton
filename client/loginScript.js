const input = document.querySelector('input[name=login_email]');
const link = document.querySelector('.loginSubmit');

input.addEventListener('input', () => {
  link.href = './user.html?id=' + input.value;
});