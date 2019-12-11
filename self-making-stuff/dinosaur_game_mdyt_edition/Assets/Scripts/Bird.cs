using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bird : MonoBehaviour
{
    private Animator anim;
    private Rigidbody2D rb2d;
    private AudioSource audio;

    public static float upForce = 800f;
    public static float gravityScale = 2.0f;

    // Start is called before the first frame update
    void Start()
    {
        anim = GetComponent<Animator>();
        rb2d = GetComponent<Rigidbody2D>();
        audio = GetComponent<AudioSource>();
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

        if (Input.GetKeyDown("space") && rb2d.gravityScale == 0)
        {
            rb2d.velocity = new Vector2(0, 9f);
            rb2d.gravityScale = gravityScale;
            anim.SetTrigger("Flap");
            anim.ResetTrigger("Run");
            audio.Play();
        }
    }

    void OnCollisionEnter2D(Collision2D other)
    {
        GameControl.instance.BirdDied();
        anim.SetTrigger("Die");
        rb2d.velocity = Vector2.zero;
        rb2d.gravityScale = 0f;
    }

    void OnTriggerEnter2D(Collider2D other)
    {
        if (other.GetComponent<Column>() == null)
        {
            rb2d.velocity = Vector2.zero;
            rb2d.gravityScale = 0f;
            anim.SetTrigger("Run");
            anim.ResetTrigger("Flap");
        }
    }
}
