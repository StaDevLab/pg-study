var permute = function (nums) {
  let path = [];
  let answer = [];

  function backtrack() {
    if (path.length === nums.length) {
      answer.push([...path]);
      return;
    }

    for (let i = 0; i < nums.length; i++) {
      if (path.includes(nums[i])) {
        continue;
      }

      path.push(nums[i]);

      backtrack();

      path.pop();
    }
  }

  backtrack();

  return answer;
};
