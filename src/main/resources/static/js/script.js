// Get theme from local storage
const getTheme = () => {
    let theme = localStorage.getItem("theme")
    return theme ? theme : "light"
}

// Store theme in local storage
const setTheme = (theme) => {
    localStorage.setItem("theme", theme)
}

window.addEventListener('load', function() {
    let currentTheme = getTheme()
    const changeThemeButton = document.querySelector('#theme_change_button')
    if (currentTheme==='light')
    {
        document.querySelector('html').classList.remove("dark")
        setTheme(currentTheme)
        document.querySelector('html').classList.add("light")
    }
    else
    {
            document.querySelector('html').classList.remove("light")
            setTheme(currentTheme)
            document.querySelector('html').classList.add("dark")
    }
    changeThemeButton.querySelector('span').textContent=currentTheme==='light'?'Dark':'Light'

});

const changeTheme = () => {
    //  set the listener to change theme button
    const changeThemeButton = document.querySelector('#theme_change_button')
    changeThemeButton.addEventListener("click", (event) => {
        const oldTheme=currentTheme
        if (currentTheme === 'dark') {
            currentTheme = "light"
        } else {
            currentTheme = "dark"
        }
        document.querySelector('html').classList.remove(oldTheme)
        setTheme(currentTheme)
        document.querySelector('html').classList.add(currentTheme)

        // change the text of button
        changeThemeButton.querySelector('span').textContent=currentTheme==='light'?'Dark':'Light'
    })
}

let currentTheme = getTheme()

changeTheme()


