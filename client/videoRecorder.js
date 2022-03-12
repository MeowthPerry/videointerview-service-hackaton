navigator.mediaDevices.getUserMedia({ audio: true, video: true})
    .then(stream => {

        var options;
        if (MediaRecorder.isTypeSupported('video/webm;codecs=vp9')) {
            options = {mimeType: 'video/webm; codecs=vp9'};
        } else {
            options = {mimeType: 'video/webm; codecs=vp8'};
        }
        const mediaRecorder = new MediaRecorder(stream, options);
        mediaRecorder.ondataavailable
        document.querySelector('#start').addEventListener('click', function(){
            mediaRecorder.start();
        });
        let videoChunks = [];
        mediaRecorder.addEventListener("dataavailable",function(event) {
            // console.log(mediaRecorder.mimeType);
            videoChunks.push(event.data);
        });
        mediaRecorder.addEventListener("stop", function() {
            const videoBlob = new Blob(videoChunks);
            let reader = new FileReader();
            reader.readAsDataURL(videoBlob);
            // console.log(mediaRecorder.mimeType)
            reader.onloadend = function () {
                var base64String = reader.result;
                console.log('Base64 String - ', base64String);
            }
        });
        document.querySelector('#stop').addEventListener('click', function(){
            mediaRecorder.stop();
        });
    });