let s = "abcdefghjikg";

//bad approach
function subs(s) {
    let trolly = []
    helper(s, 0, [], trolly);
    return trolly

    function helper(s, i, bag, trolly) {
     
        if(i == s.length) {
            trolly.push([...bag])
            return
        }
        bag.push(s[i])
        helper(s, i+1, bag, trolly)

        bag.pop();
        helper(s, i+1, bag, trolly)
    }
}

//Good independent sub problems approach

function subs(s) {
    return helper(s, 0);
    
    //ab
    function helper(s, i) {
        count++;
        if(i == s.length) {
            return [[]];
        }
        
        let herTrolly = helper(s, i+1)// => [[b], []]
        let myTrolly = [];
        
        for(let bag of herTrolly) {
            myTrolly.push([...bag]);
            myTrolly.push([...bag, s[i]]);
        }
        return myTrolly;
        //myTrolly => [[b], [], [a, b], [a]]
    }
}

subs(s)
