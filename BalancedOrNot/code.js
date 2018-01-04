function balancedOrNot(exprs, maxReps) {
    var result = [];
    var len = exprs.length;
	for (var i=0; i<len; i++) {
        result.push(replace(exprs[i], maxReps[i]))
    }
    return result;
}

function replace(expr, maxRep) {
    var count = 0;
    var len = expr.length;
    for (var i=0; i<len; i++) {
        var ch = expr.charAt(i);
        if (ch === '<') {
            count ++;
        }else {
            if (maxRep == 0) {
                return 0;
            }
            count --;
        }
    }
    return count === 0 ? 1 : 0;
}