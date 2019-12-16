function geta(target, start, end) {
    var r = [];
    var last = -1;
    for (var i = start; i <= end; i++) {
        var tag = 1;
        for (var j = 2; j * j <= i - 1; j++) {
            if (i % j == 0) {
                tag = 0;
                break;
            }
        }
        if (tag == 1) {
            if (last + target == i) {
                r.push(last);
                r.push(i);
                break;
            } else {
                last = i;
            }
        }
    }
    return r;
}
var z = geta(300, 400, 10);
console.log(z);

function findPrimeNumbers(start, end) {
    var r = [];
    for (var i = start; i <= end; i++) {
        var tag = 1;
        for (var j = 2; j * j <= i - 1; j++) {
            if (i % j == 0) {
                tag = 0;
                break;
            }
        }
        if (tag == 1) {
            r.push(i);
        }
    }
    return r;
}

var z = findPrimeNumbers(3, 15);
console.log(z);
