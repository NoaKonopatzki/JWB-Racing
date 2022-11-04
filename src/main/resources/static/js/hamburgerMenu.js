const toggleButton = document.getElementsByClassName('toggle-button')[0]
const navbarLinks = document.getElementsByClassName('navbar')[0]
const bar1 = document.getElementsByClassName('bar-1')[0]
const bar2 = document.getElementsByClassName('bar-2')[0]
const bar3 = document.getElementsByClassName('bar-3')[0]


toggleButton.addEventListener('click', () => {
    navbarLinks.classList.toggle('active')
    bar1.classList.toggle('active')
    bar2.classList.toggle('active')
    bar3.classList.toggle('active')
})