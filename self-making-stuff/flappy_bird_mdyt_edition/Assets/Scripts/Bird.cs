using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bird : MonoBehaviour
{
    public float upForce = 200f;

    public AudioClip flapSound;
    public AudioClip scoreSound;
    public AudioClip diedSound;

    private AudioSource birdAudio;
    private AudioSource scoreAudio;

    private bool isDead = false;
    private Animator anim;
    private Rigidbody2D rb2d;


    public static Bird instance;

    void Awake()
    {
        if (instance == null)
            instance = this;
        else if (instance != this)
            Destroy(gameObject);
    }

    public void SetGravityScale(float value)
    {
        rb2d.gravityScale = value;
    }


    void Start()
    {
        birdAudio = GetComponent<AudioSource>();
        scoreAudio = GameControl.instance.audio;
        birdAudio.clip = flapSound;
        scoreAudio.clip = scoreSound;

        anim = GetComponent<Animator>();
        rb2d = GetComponent<Rigidbody2D>();
        rb2d.gravityScale = 0f;
    }

    void Update()
    {
        if (isDead) return;
        if (Input.GetKeyDown("space"))
        {
            birdAudio.Play();
            anim.SetTrigger("Flap");
            rb2d.velocity = Vector2.zero;
            rb2d.AddForce(new Vector2(0, upForce));
        }
    }

    void OnCollisionEnter2D(Collision2D other)
    {
        if (isDead) return;
        birdAudio.clip = diedSound;
        birdAudio.Play();
        GameControl.instance.BirdDied();
        anim.SetTrigger("Die");
        rb2d.velocity = Vector2.zero;
        isDead = true;
    }
}
