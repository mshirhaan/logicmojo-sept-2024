let n1 = {val:1};
let n2 = {val:2};
let n3 = {val:3};
let n4 = {val:4};
let n5 = {val:5};
let n6 = {val: 6};
let n7 = {val: 7}

n1.left = n2
n1.right = n3
n2.left = n4
n2.right = n5
n3.left = n6;
n3.right = n7;

let dfscount = 0;
let bfscount = 0;

function dfsSearch( root, key) {
    function helper( node) {
        dfscount++;
        if(node == null) return false;
        if(node.val == key) {
            return true;
        }
        
        if(node.left && helper(node.left)) {
            return true;
        }
        
        if(node.right && helper(node.right)) {
            return true;
        }
        return false;
    }
    return helper(root);
}

function bfsSearch(root, key) {
    if(root == null) return false;

    let queue = [];
    queue.push(root);

    while(queue.length>0) {
        bfscount++;
        let current = queue.shift();
        if(current.val == key) {
            return true;
        }
        if(current.left != null) {
            queue.push(current.left);
        }
        if(current.right != null) {
            queue.push(current.right);
        }
    }
    return false;
}

console.log('dfs', dfsSearch(n1,7)) //pradeep
console.log('bfs', bfsSearch(n1,7)); //smaranika

console.log('dfsCount', dfscount)
console.log('bfsCount', bfscount)
