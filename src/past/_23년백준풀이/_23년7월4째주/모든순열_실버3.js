const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const result = [];
const list = [];
const visited = new Array(9).fill(false); // n은 최대 8개

rl.on("line", function(line) {
  const n = Number(line);
  executeDFS(0, n);
  console.log(result.join("\n"));
  rl.close();
});

const executeDFS = (count, n) => {
  if (count === n) {
    result.push(list.join(" "));
    return;
  }

  for (let i = 1; i <= n; i++) {
    if (!visited[i]) {
      visited[i] = true;
      list.push(i);
      executeDFS(count + 1, n);
      list.pop();
      visited[i] = false;
    }
  }
};