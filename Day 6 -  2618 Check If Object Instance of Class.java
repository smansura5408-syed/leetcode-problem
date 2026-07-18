/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined) {
        return false;
    }
    if (typeof classFunction !== "function"){
        return false;
    }
    while (obj != null) {
        if(Object.getPrototypeOf(obj) === classFunction.prototype){
            return true;
        }
        obj = Object.getPrototypeOf(obj);
    }
    return false;
};
