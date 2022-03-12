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

promise.then((data) => console.log(data.name))

