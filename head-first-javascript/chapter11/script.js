class Blog {
    constructor(body, date) {
        this.body = body;
        this.date = date;
    }
}

function createBlogContentElement(blog) {
    const date = document.createElement('p');
    date.className = 'blog-date';
    date.innerHTML = blog.date.toLocaleDateString('vi-VN');

    const body = document.createElement('p');
    body.className = 'blog-body';
    body.innerHTML = blog.body;

    const div = document.createElement('div');
    div.appendChild(date);
    div.appendChild(body);
    div.className = 'blog-content';
    return div;
}

function showBlogs(blogs, numEntries) {
    if (blogs) {
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
            button.addEventListener("click", () => showMoreBlogs(blogs, curBlogIndex));
            blogSection.append(button);
        }
    }
    else throw new Error('Cannot show blogs');
}

function showMoreBlogs(blogs, curBlogIndex) {
    if (blogs) {
        const blogSection = document.getElementById('blog');
        const buttonMoreBlogs = document.getElementById('more-blogs');
        blogSection.removeChild(buttonMoreBlogs);

        while (curBlogIndex < blogs.length) {
            const blog = blogs[curBlogIndex++];
            const blogContent = createBlogContentElement(blog);
            blogSection.appendChild(blogContent);
        }
    }
    else throw new Error('Cannot show more blogs');
}

function getBlogs() {
    const ajaxReq = new AjaxRequest();
    ajaxReq.send("GET", "blog.xml", () => {
        const isResponed = ajaxReq.getReadyState() == 4 && ajaxReq.getStatus() == 200;
        if (isResponed) {
            const xmlData = ajaxReq.getResponseXML().getElementsByTagName('blog')[0];
            const entries = xmlData.getElementsByTagName('entry');
            let blogs = [];
            for (const entry of entries) {
                blogs.push(new Blog(getText(entry.getElementsByTagName('body')[0]),
                    new Date(getText(entry.getElementsByTagName('date')[0]))));
            }
            blogs.sort((blog1, blog2) => blog2.date - blog1.date);
            showBlogs(blogs, numEntries = 3);
        }
    });
}

function getText(elem) {
    let text = "";
    if (elem) {
        if (elem.childNodes) {
            for (let i = 0; i < elem.childNodes.length; i++) {
                const child = elem.childNodes[i];
                if (child.nodeValue)
                    text += child.nodeValue;
                else {
                    if (child.childNodes)
                        if (child.childNodes[0].nodeValue)
                            text += child.childNodes[0].nodeValue;
                }
            }
        }
    }
    return text;
}
