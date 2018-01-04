function waitingTime(tickets, pos) {
    var result = buyTicket(tickets, pos, 0);
    return result;
}

function buyTicket(tickets, pos, time) {
    var current = tickets.splice(0, 1)[0];
    time++;
    if (pos == 0) {
        if (current == 1) {
            return time;
        }
        pos = tickets.length;
    }else {
        pos--;
    }
    if (current > 1) {
        tickets.push(current - 1);
    } 
    return buyTicket(tickets, pos, time);
}
