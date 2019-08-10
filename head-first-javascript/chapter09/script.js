class Blog {
    constructor(body, date) {
        this.body = body;
        this.date = date;
    }
}

const blogs = [
    new Blog("Got the new cube I ordered. It's a real pearl.", new Date("08/14/2008")),
    new Blog("Solved the new cube but of course, now I'm bored and shopping for a new one.", new Date("08/19/2008")),
    new Blog("Managed to get a headache toiling over the new cube. Gotta nap.", new Date("08/16/2008")),
    new Blog("Found a 7x7x7 cube for sale online. Yikes! That one could be a beast.", new Date("08/21/2008"))
];

blogs.sort((blog1, blog2) => {
    return blog2.date - blog1.date;
})

function createBlogContentElement(blog) {
    const date = document.createElement('p');
    date.className = 'blog-date';
    date.innerHTML = blog.date.toLocaleDateString('en-US');

    const body = document.createElement('p');
    body.className = 'blog-body';
    body.innerHTML = blog.body;

    const div = document.createElement('div');
    div.appendChild(date);
    div.appendChild(body);
    div.className = 'blog-content';
    return div;
}

function showBlogs(numEntries) {
    numEntries = Math.min(numEntries, blogs.length);
    const blogSection = document.getElementById('blog');
    let curBlogIndex = 0;

    while (curBlogIndex < numEntries) {
        const blog = blogs[curBlogIndex++];
        const blogContent = createBlogContentElement(blog);
        blogSection.appendChild(blogContent);
    }

    if (numEntries < blogs.length) {
        const button = document.createElement('button');
        button.innerHTML = 'Show all blogs';
        button.id = "more-blogs";
        button.addEventListener("click", () => showMoreBlogs(curBlogIndex));
        blogSection.append(button);
    }
}

function showMoreBlogs(curBlogIndex) {
    const blogSection = document.getElementById('blog');
    const buttonMoreBlogs = document.getElementById('more-blogs');
    blogSection.removeChild(buttonMoreBlogs);

    while (curBlogIndex < blogs.length) {
        const blog = blogs[curBlogIndex++];
        const blogContent = createBlogContentElement(blog);
        blogSection.appendChild(blogContent);
    }
}