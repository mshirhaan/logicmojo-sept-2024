var verticalTraversal = function(root) {
    let map = {};
    let res = []
    let maxX = 0;
    let minX = 0;

    let queue = [{node : root, x: 0, y: 0}];

    while(queue.length) {
        let {node, x, y} = queue.shift();

        if(x < minX) minX = x;
        if(x > maxX) maxX = x;

        if(!map[x]) {
            map[x] = [];
        }
        map[x].push({val: node.val, y: y});

        if(node.left) {
            queue.push({node: node.left, x: x-1, y: y+1});
        }
        if(node.right) {
            queue.push({node: node.right, x: x+1, y: y+1});
        }
    }

    for(let i = minX; i<= maxX; i++) {
        res.push([...map[i].sort(function(a,b){
            if(a.y == b.y) {
                return a.val-b.val;
            }
            return a.y-b.y;
        })
        .map(a=>a.val)]);
    }
    return res;
};
