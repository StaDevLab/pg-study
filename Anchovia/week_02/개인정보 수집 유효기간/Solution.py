def change_days(date):
        y, m, d = map(int, date.split("."))
        return y * 12 * 28 + m * 28 + d

def solution(today, terms, privacies):
    answer = []
    
    term_dict = {}
    for term in terms:
        name, month = term.split()
        term_dict[name] = int(month)

    today_days = change_days(today)
    for i, priv in enumerate(privacies):
        date, term = priv.split()

        start_days = change_days(date)
        expire_days = start_days + term_dict[term] * 28

        if expire_days <= today_days:
            answer.append(i + 1)

    return answer