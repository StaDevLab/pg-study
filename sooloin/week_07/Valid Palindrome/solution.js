var isPalindrome = function (s) {
  let clean = s.toLowerCase().replace(/[^a-z0-9]/g, "");
  let left = 0;
  let right = clean.length - 1;

  while (left < right) {
    if (clean.at(left) === clean.at(right)) {
      left++;
      right--;
    } else {
      return false;
    }
  }

  return true;
};
