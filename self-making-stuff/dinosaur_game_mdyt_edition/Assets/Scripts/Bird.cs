using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bird : MonoBehaviour
{
    private Animator anim;
    private Rigidbody2D rb2d;
    public float upForce = 800f;

    // Start is called before the first frame update
    void Start()
    {
        anim = GetComponent<Animator>();
        rb2d = GetComponent<Rigidbody2D>();
        anim.SetTrigger("Run");
    }

    // Update is called once per frame
    void Update()
    {
        if (GameControl.instance.gameOver)
        {
            rb2d.velocity = Vector2.zero;
            return;
        }

        if (Input.GetMouseButtonDown(0) && rb2d.gravityScale == 0)
        {
            rb2d.velocity = new Vector2(0, 9f);
            rb2d.gravityScale = 2f;
            anim.SetTrigger("Flap");
            anim.ResetTrigger("Run");
        }
    }

    void OnCollisionEnter2D(Collision2D other)
    {
        rb2d.velocity = Vector2.zero;
        if (other.gameObject.tag == "Column")
        {
            anim.SetTrigger("Die");
            GameControl.instance.BirdDied();
            rb2d.gravityScale = 1f;
            return;
        }

        rb2d.gravityScale = 0f;
        anim.SetTrigger("Run");
    }
}
