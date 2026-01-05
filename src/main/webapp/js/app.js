document.addEventListener('DOMContentLoaded', () => {
    // Smooth scrolling for anchor links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });

    // Add scroll effect to header
    const header = document.querySelector('header');
    window.addEventListener('scroll', () => {
        if (window.scrollY > 50) {
            header.style.padding = '10px 0';
            header.style.backgroundColor = 'rgba(255, 255, 255, 0.95)';
            header.style.backdropFilter = 'blur(10px)';
        } else {
            header.style.padding = '20px 0';
            header.style.backgroundColor = 'var(--white)';
            header.style.backdropFilter = 'none';
        }
    });

    // Simple interaction feedback for "Add to Cart"
    const cartButtons = document.querySelectorAll('form[action="cart"] button');
    cartButtons.forEach(button => {
        button.addEventListener('click', (e) => {
            // Optional: Could add AJAX here if the backend supports it
            // For now, just a visual feedback before form submission
            button.innerText = 'Adding...';
            button.style.transform = 'scale(0.95)';
        });
    });
});
