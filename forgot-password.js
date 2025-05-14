/**
 * 
 */
function toggleForgotPassword(element) {
    const passwordInput = element.previousElementSibling;
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        element.textContent = "🙈";
    } else {
        passwordInput.type = "password";
        element.textContent = "👁️";
    }
}

