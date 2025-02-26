document.addEventListener("DOMContentLoaded", function() {
    const typeSelect = document.getElementById("select-ty");
    const parent = document.querySelector("main"); // والد مشترک بخش‌ها (مثلاً `<main>`)
    const sections = {
        bk: document.getElementById("boo"),
        vd: document.getElementById("vid"),
        br: document.getElementById("brc")
    };

    // تابع برای جابجایی بخش‌ها
    function reorderSections(selectedType) {
        const selectedSection = sections[selectedType];
        const children = Array.from(parent.children); // لیست فرزندان والد
        
        // اگر بخش انتخاب شده از قبل بالای صفحه است، هیچ کاری نکن
        if (children.indexOf(selectedSection) === 0) return;

        // جابجایی بخش انتخاب شده با بخش بالای صفحه
        const currentTop = children[0]; // بخش فعلی بالای صفحه
        const selectedIndex = children.indexOf(selectedSection); // موقعیت اصلی بخش انتخاب شده
        
        // انتقال بخش انتخاب شده به بالای صفحه
        parent.insertBefore(selectedSection, currentTop);
        
        // انتقال بخش قبلی بالای صفحه به موقعیت اصلی بخش انتخاب شده
        const newChildren = Array.from(parent.children);
        const targetPosition = selectedIndex === 0 ? 0 : selectedIndex;
        parent.insertBefore(currentTop, newChildren[targetPosition + 1] || null);
    }

    // رویداد تغییر گزینه در dropdown
    typeSelect.addEventListener("change", function() {
        reorderSections(this.value);
    });

    // تنظیم پیش‌فرض روی 'bk' (کتاب)
    typeSelect.value = "bk";
    reorderSections("bk");
});