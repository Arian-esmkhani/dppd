class AutoCarousel {
    constructor() {
        this.track = document.querySelector('.b-slider-track');
        this.items = document.querySelectorAll('.b-article');
        this.btnPrev = document.querySelector('.prev');
        this.btnNext = document.querySelector('.next');
        this.visibleItems = 5;
        this.totalItems = this.items.length;
        this.currentIndex = 0;
        this.autoPlayInterval = null;
        this.isTransitioning = false;

        this.init();
    }

    init() {
        // Clone items برای چرخش بی‌نهایت
        const cloneItems = [];
        this.items.forEach(item => cloneItems.push(item.cloneNode(true)));
        cloneItems.forEach(item => this.track.appendChild(item));

        this.trackWidth = this.track.scrollWidth;
        this.itemWidth = this.items[0].offsetWidth;
        
        this.btnPrev.addEventListener('click', () => this.move('prev'));
        this.btnNext.addEventListener('click', () => this.move('next'));
        this.startAutoPlay();
        this.updateItems();
    }

    move(direction) {
        if(this.isTransitioning) return;
        this.isTransitioning = true;
        
        this.currentIndex = direction === 'next' ? 
            this.currentIndex + this.visibleItems : 
            this.currentIndex - this.visibleItems;

        const offset = this.currentIndex * this.itemWidth;
        
        this.track.style.transition = 'transform 0.5s ease-in-out';
        this.track.style.transform = `translateX(-${offset}px)`;

        setTimeout(() => {
            this.checkBoundaries();
            this.updateItems();
            this.isTransitioning = false;
        }, 500);
    }

    checkBoundaries() {
        if(this.currentIndex >= this.totalItems) {
            this.currentIndex = 0;
            this.track.style.transition = 'none';
            this.track.style.transform = `translateX(0)`;
        }
        if(this.currentIndex < 0) {
            this.currentIndex = this.totalItems - this.visibleItems;
            this.track.style.transition = 'none';
            this.track.style.transform = `translateX(-${(this.totalItems - this.visibleItems) * this.itemWidth}px)`;
        }
    }

    updateItems() {
        this.items.forEach((item, index) => {
            const isActive = index >= this.currentIndex && 
                           index < this.currentIndex + this.visibleItems;
            item.classList.toggle('active', isActive);
        });
    }

    startAutoPlay() {
        this.autoPlayInterval = setInterval(() => {
            this.move('next');
        }, 5000);
    }

    stopAutoPlay() {
        clearInterval(this.autoPlayInterval);
    }
}

// راه اندازی اسلایدر
new AutoCarousel();