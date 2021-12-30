let stepCount = 8

function render_grid() {
    let canvas = document.getElementById("target_canvas")
    if (canvas.getContext) {
        let ctx = document.getElementById("target_canvas").getContext('2d')
        let width = canvas.width
        let height = canvas.height
        let stepX = width / stepCount
        let stepY = height / stepCount
        ctx.beginPath();
        ctx.moveTo(0, height / 2);
        ctx.lineTo(width, height / 2);
        ctx.stroke();
        ctx.beginPath()
        ctx.moveTo(width / 2, 0)
        ctx.lineTo(width / 2, height)
        ctx.stroke()
        let mark_size = (width + height) / (2 * 50)
        ctx.font = "14px Courier New"
        ctx.beginPath()
        for (let i = stepX; i < width; i += stepX) {
            ctx.moveTo(i, height / 2 + mark_size)
            let digit = -stepCount / 2 + i / stepX
            digit = digit === 0 ? "" : digit
            ctx.fillText(digit, i - 3, height / 2 + mark_size + mark_size)
            ctx.lineTo(i, height / 2 - mark_size)
        }
        ctx.stroke()
        ctx.beginPath()
        for (let i = stepY; i < height; i += stepY) {
            ctx.moveTo(width / 2 + mark_size, i)
            let digit = stepCount / 2 - i / stepY
            digit = digit === 0 ? "" : digit
            ctx.fillText(digit, width / 2 + mark_size + mark_size / 2, i + 3)
            ctx.lineTo(width / 2 - mark_size, i)
        }
        ctx.stroke()

    }
}

function render_target(r) {
    let canvas = document.getElementById("target_canvas")
    if (canvas.getContext) {
        let ctx = document.getElementById("target_canvas").getContext('2d')
        let width = canvas.width
        let height = canvas.height
        let stepX = width / stepCount
        let stepY = height / stepCount
        ctx.fillStyle = "darkblue"
        ctx.globalAlpha = 0.5
        ctx.fillRect(width / 2, height / 2, stepX * r / 2, stepY * r)
        ctx.beginPath()
        ctx.arc(width / 2, height / 2, r / 2 * stepX, Math.PI, Math.PI * 3 / 2, false)
        ctx.lineTo(width / 2, height / 2)
        ctx.fill()
        ctx.beginPath()
        ctx.moveTo(width / 2, height / 2)
        ctx.lineTo(width / 2 + r * stepX, height / 2)
        ctx.lineTo(width / 2, height / 2 -  r *  stepY)
        ctx.fill()
        ctx.globalAlpha = 1.0
        ctx.fillStyle = "black"

    }
}

function render_canvas(r) {

    let canvas = document.getElementById("target_canvas")
    if (canvas.getContext) {
        let ctx = document.getElementById("target_canvas").getContext('2d')
        let width = canvas.width
        let height = canvas.height
        ctx.clearRect(0, 0, width, height)
    }
    render_grid()
    render_target(r)
    render_hits(r)
}

function get_table_from_dom() {
    let table = Array()
    let table_dom = document.getElementById("hits_data")
    let rows_dom = table_dom.getElementsByTagName("tr")
    Array.from(rows_dom).forEach(row => {
        let columns = row.cells
        if(columns.length === 4) {
            table.push([columns[0].textContent, columns[1].textContent, columns[2].textContent, columns[3].textContent])
        }
    })
    return table
}

function get_r() {
    return  document.getElementById("canvas_form:canvas_r").value
}

function get_link() {
    alert("commandLink {'1', '1,5', '2', '2,5', '3'}")
}

function render_hits(r) {
    let canvas = document.getElementById("target_canvas")

    if (canvas.getContext) {
        let ctx = document.getElementById("target_canvas").getContext('2d')
        let width = canvas.width
        let height = canvas.height
        let stepX = width / stepCount
        let stepY = height / stepCount
        let table = get_table_from_dom()
        console.log(table)
        table.forEach(hit => {
            let r_ = hit[2]
            if (r_ <= 0) return
            let r = get_r()
            let scale = 1
            let x = hit[0] * scale * stepX + width / 2
            let y = -hit[1] * scale * stepY + height / 2
            let isHit = hit[3]
            ctx.beginPath()
            if (isHit === "false") ctx.fillStyle = "red"
            else ctx.fillStyle = "green"
            ctx.globalAlpha = 0.7
            ctx.ellipse(x, y, stepX / 10, stepY / 10, 0, 0, Math.PI * 2, true)
            ctx.fill()
            ctx.fillStyle = "black"
            ctx.globalAlpha = 1
        })

    }

}

function shoot_by_canvas(canvas, event) {
    let rect = canvas.getBoundingClientRect()
    let width = canvas.width
    let height = canvas.height
    let stepX = width / stepCount
    let stepY = height / stepCount
    let x = -(canvas.width / 2 - (event.clientX - rect.left)) / stepX
    let y = (canvas.height / 2 - (event.clientY - rect.top)) / stepY


    $(".canvas_x").attr("value", Math.ceil(x * 100) / 100).change();
    $(".canvas_y").attr("value", Math.ceil(y * 100) / 100).change();
    document.getElementById("canvas_form:canvas_button").click()
    console.log(x, y)

}

function canvas_init() {
    let r = get_r()
    if (r < 1) r = 1
    render_canvas(r)
    let canvas = document.getElementById("target_canvas")
    canvas.addEventListener('mousedown', event => shoot_by_canvas(canvas, event))
}
