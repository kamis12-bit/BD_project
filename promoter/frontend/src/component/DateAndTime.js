const getFormattedDateAndTime = function (date) {
  const dateObj = new Date(date)
  const year = dateObj.getFullYear()
  let month = dateObj.getMonth() + 1
  if (month < 10)
    month = '0' + month.toString()
  let day = dateObj.getDate()
  if (day < 10)
    day = '0' + day.toString()

  let hour = dateObj.getHours()
  if (hour < 10)
    hour = '0' + hour.toString()
  let minutes = dateObj.getMinutes()
  if (minutes < 10)
    minutes = '0' + minutes.toString()
  let seconds = dateObj.getSeconds()
  if (seconds < 10)
    seconds = '0' + seconds.toString()

  return `${day}.${month}.${year} ${hour}:${minutes}:${seconds}`
}

export default getFormattedDateAndTime;