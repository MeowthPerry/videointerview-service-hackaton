function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

const uid = getUrlVars().id;

const status = function (response) {
    if (response.status !== 200) {
        return Promise.reject(new Error(response.statusText));
    }
    return Promise.resolve(response);
}
const json = function (response) {
    return response.json();
}

var promise = fetch('http://127.0.0.1:8080/api/user/' + uid, {
    method: 'get'
})
.then(status)
.then(json)
.catch(function (error) {
    console.log('error', error)
})

const responseData = promise.then((data) => {return data});

export { responseData, uid };