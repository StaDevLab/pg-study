function solution(fees, records) {
  const [baseTime, baseFee, unitTime, unitFee] = fees;

  const inTimes = new Map();
  const totalTimes = new Map();

  const convertToMinutes = (time) => {
    const [hour, minute] = time.split(":").map(Number);

    return hour * 60 + minute;
  };

  for (const record of records) {
    const [time, carNumber, status] = record.split(" ");
    const minutes = convertToMinutes(time);

    if (status === "IN") {
      inTimes.set(carNumber, minutes);
    } else {
      const parkingTime = minutes - inTimes.get(carNumber);

      totalTimes.set(carNumber, (totalTimes.get(carNumber) || 0) + parkingTime);

      inTimes.delete(carNumber);
    }
  }

  const endTime = convertToMinutes("23:59");

  for (const [carNumber, inTime] of inTimes) {
    totalTimes.set(
      carNumber,
      (totalTimes.get(carNumber) || 0) + endTime - inTime,
    );
  }

  return [...totalTimes.keys()].sort().map((carNumber) => {
    const totalTime = totalTimes.get(carNumber);

    if (totalTime <= baseTime) {
      return baseFee;
    }

    const extraTime = totalTime - baseTime;

    return baseFee + Math.ceil(extraTime / unitTime) * unitFee;
  });
}
